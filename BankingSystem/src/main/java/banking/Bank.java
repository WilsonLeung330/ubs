package banking;

import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<Long, Account>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		String uk = company.getCompanyName()+company.getIdNumber();
		Long accountNumber = UUID.nameUUIDFromBytes(uk.getBytes()).getMostSignificantBits();
		CommercialAccount commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, commercialAccount);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		String uk = person.getFirstName()+person.getLastName()+person.getIdNumber();
		Long accountNumber = UUID.nameUUIDFromBytes(uk.getBytes()).getMostSignificantBits();
		ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, consumerAccount);
        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
        return accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return accounts.get(accountNumber).debitAccount(amount);
	}
}
