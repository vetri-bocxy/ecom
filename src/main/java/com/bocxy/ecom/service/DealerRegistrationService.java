package com.bocxy.ecom.service;


import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.model.Role;
import com.bocxy.ecom.model.User;
import com.bocxy.ecom.repository.DealerRegistrationRepository;
import com.bocxy.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DealerRegistrationService {

    @Autowired
    DealerRegistrationRepository dealerRegistrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;


    public DealerRegistrationEntity create(DealerRegistrationEntity entity) {

        DealerRegistrationEntity savedDealer = dealerRegistrationRepository.save(entity);

        // Send Welcome Mail
        String subject = "Welcome to Bocxy Portal - Pending Approval";
        String body = "Hello " + savedDealer.getBusinessName() + ",\n\n"
                + "Thank you for registering with us. Your dealer account is currently under review.\n"
                + "You will receive an email once it has been approved.\n\n"
                + "Regards,\nBocxy Team";

        emailService.sendEmail(savedDealer.getEmail(), subject, body);

        return savedDealer;
    }


    @Transactional
    public void rejectDealer(Long dealerId, String reason) {
        DealerRegistrationEntity dealer = dealerRegistrationRepository.findById(dealerId)
                .orElseThrow(() -> new RuntimeException("Dealer not found"));

        if (!"PENDING".equalsIgnoreCase(dealer.getStatus())) {
            throw new RuntimeException("Dealer is not pending approval");
        }

        dealer.setStatus("REJECTED");
        dealer.setRejectionReason(reason);
        dealerRegistrationRepository.save(dealer);
    }

    public List<DealerRegistrationEntity> getAll() {
        return dealerRegistrationRepository.findAll();
    }

    public DealerRegistrationEntity update(DealerRegistrationEntity entity) {
        return dealerRegistrationRepository.save(entity);
    }

    @Transactional
    public void approveDealers(List<Long> dealerIds) {

        for (Long dealerId : dealerIds) {

            DealerRegistrationEntity dealer = dealerRegistrationRepository.findById(dealerId)
                    .orElseThrow(() -> new RuntimeException("Dealer Id Not Found " + dealerId));

            if (!"PENDING".equalsIgnoreCase(dealer.getStatus())) {
                throw new RuntimeException("Dealer with ID " + dealerId + " is not pending approval");
            }

            // Update status
            dealer.setStatus("APPROVED");
            dealerRegistrationRepository.save(dealer);

            // Create User account
            User user = new User();
            user.setEmail(dealer.getEmail());
            user.setPassword(passwordEncoder.encode(dealer.getPassword())); // Store encoded password
            user.setRole(Role.DEALER);
            user.setStatus(true);
            userRepository.save(user);

            // Send Approval Email with credentials
            String subject = "Bocxy Portal - Dealer Account Approved";
            String body = "Hello " + dealer.getBusinessName() + ",\n\n"
                    + "We are pleased to inform you that your dealer account has been approved.\n"
                    + "You can now log in to the Bocxy Portal using your credentials below:\n\n"
                    + "Login URL: https://bocxy.example.com/login\n"
                    + "Username: " + dealer.getEmail() + "\n"
                    + "Password: " + dealer.getPassword() + "  (Please change after first login)\n\n"
                    + "Regards,\nBocxy Team";

            emailService.sendEmail(dealer.getEmail(), subject, body);
        }
    }
}
