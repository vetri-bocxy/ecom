package com.bocxy.ecom.service;


import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.model.Role;
import com.bocxy.ecom.model.User;
import com.bocxy.ecom.repository.DealerRegistrationRepository;
import com.bocxy.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;


import javax.persistence.EntityNotFoundException;
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

        // Prepare dynamic content
        String dealerName = savedDealer.getBusinessName(); // Dealer's name dynamically
        String emailBody = "Dear " + dealerName + ",\n\n"
                + "Thank you for showing interest in partnering with Bocxy Technologies.\n\n"
                + "We have received your dealer registration request and our team will review your details shortly.\n\n"
                + "Once approved, you will receive your dealer account login credentials to access our platform.\n\n"
                + "This is an automated message, please do not reply.\n"
                + "For assistance, contact +91-97878 97873\n\n"
                + "Best Regards,\nTeam Bocxy Technologies";

        String subject = "Welcome to Bocxy Portal - Pending Approval";

        // Log the content that will be sent
        System.out.println("Sending email to: " + savedDealer.getEmail());
        System.out.println("Email subject: " + subject);
        System.out.println("Email body: " + emailBody);

        // Send the email
        emailService.sendEmail(savedDealer.getEmail(), subject, emailBody);

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

            String rawPassword = RandomStringUtils.randomAlphanumeric(10);

            // Create User account
            User user = new User();
            user.setEmail(dealer.getEmail());
            user.setPassword(passwordEncoder.encode(rawPassword)); // Store encoded password
            user.setRole(Role.DEALER);
            user.setStatus(true);
            userRepository.save(user);

            // Send Approval Email with credentials
            String subject = "Bocxy Portal - Dealer Account Approved";
            String body = "Dear " + dealer.getBusinessName() + ",\n\n"
                    + "We are pleased to inform you that your dealer registration request with Bocxy Technologies has been approved.\n\n"
                    + "Login ID: " + dealer.getEmail() + "\n"
                    + "Password: " + rawPassword + "\n\n"
                    + "For security reasons, please change your password after your first login.\n\n"
                    + "This is an automated message, please do not reply.\n"
                    + "For assistance, contact +91-97878 97873.\n\n"
                    + "Best Regards,\n"
                    + "Team Bocxy Technologies";


            emailService.sendEmail(dealer.getEmail(), subject, body);
        }
    }

    public DealerRegistrationEntity findById(Long id) {
        return dealerRegistrationRepository.findById(id).orElseThrow(()->new EntityNotFoundException("no data found for this id "+ id));
    }

    public List<String> getAllBusinessName() {
        return dealerRegistrationRepository.findAllBusinessName();
    }

    public List<String> getAllGSTNumber() {
        return dealerRegistrationRepository.findAllGSTNumber();
    }
}
