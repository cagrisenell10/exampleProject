package accounts.web;

import accounts.internal.StubAccountManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import rewards.internal.account.Account;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AccountControllerTests {

	private static final long expectedAccountId = StubAccountManager.TEST_ACCOUNT_ID;
	private static final String expectedAccountNumber = StubAccountManager.TEST_ACCOUNT_NUMBER;

	private AccountController controller;

	@BeforeEach
	public void setUp() throws Exception {
		controller = new AccountController(new StubAccountManager());
	}



	@Test
	public void testHandleListRequest() {
		List<Account> accounts = controller.accountList();


		assertNotNull(accounts);
		assertEquals(1, accounts.size());


		Account account = accounts.get(0);
		assertEquals(expectedAccountId, (long) account.getEntityId());
		assertEquals(expectedAccountNumber, account.getNumber());
	}


	@Test
	public void testHandleDetailsRequest() {


		Account account = controller.accountDeatils(expectedAccountId);


		assertNotNull(account);
		assertEquals(expectedAccountId, account.getEntityId());
		assertEquals(expectedAccountNumber, account.getNumber());

	}

}
