package de.helpnoweatlater.backend;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = {"private", "sandbox"})
public class PayPalServiceTests {

}
