package controller;

//import static org.junit.jupiter.api.Assertions.*;

class RegisterFormControllerTest {
    public static void main(String[] args) {
        //System.out.println("Testing");
        RegisterFormController ctrl = new RegisterFormController();
        assert ctrl.isName("Eranga Bandara");
        assert (ctrl.isName("Eranga123") == false);
        assert (ctrl.isName("Eranga ()jsdbvjd]") == false);
    }
}