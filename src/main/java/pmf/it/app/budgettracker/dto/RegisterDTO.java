package pmf.it.app.budgettracker.dto;

public record RegisterDTO(
		String username,
		String password,
		String email,
		String firstName,
		String lastName
) {

}
