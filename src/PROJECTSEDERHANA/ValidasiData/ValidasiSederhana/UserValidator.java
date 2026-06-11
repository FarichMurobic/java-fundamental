package PROJECTSEDERHANA.ValidasiData.ValidasiSederhana;

public class UserValidator {

    public static void validatorUserName(String userName) throws InvalidUsernameException {
        if (userName == null || userName.trim().isEmpty()) { // trim cek spasi. empty cek kosong
            throw new InvalidUsernameException("Username tidak boleh kosong!");
        }
        if (userName.length() < 3) {
            throw new InvalidUsernameException("Username minimal 3 karakter!");
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 13) {
            throw new InvalidAgeException("Umur minimal 13 tahun!");
        }
    }

    public static void validatePassword(String password) throws WeakPasswordException {
        if (password.length() < 8) {
            throw new WeakPasswordException("Password minimal 8 karakter!");
        }
    }
}
