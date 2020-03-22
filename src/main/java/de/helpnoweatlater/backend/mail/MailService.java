package de.helpnoweatlater.backend.mail;

import de.helpnoweatlater.backend.payment.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    private static final String CUSTOMER_SUBJECT = "";
    private static final String STORE_SUBJECT = "";

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }



    public void sendVoucherConfirmation(final Payment payment) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(payment.getPurchaseUnit().payee().email());

            helper.setSubject("Dein Gutschein-Code von giessenteiltaus!");

            helper.setText("Hallo " +  payment.getPayer().name().surname() + ",\n" +
                    "Vielen Dank für deine Hilfe! Dein Gutschein-Code lautet: " + payment.getOrderId() + "\n" +
                    "\n" +
                    "Viel Grüße,\n" +
                    "Dein HelpNowEatLater-Team");

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send confirmation email to payer");
        }


    }



}
