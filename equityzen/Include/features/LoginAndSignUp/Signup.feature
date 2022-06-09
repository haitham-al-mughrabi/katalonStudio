Feature: signup

  Scenario: Sign up using new cridentails
    When The user clicks on sign_up_button
    Then The user should be navigated to signup page
    When The user clicks on investor_label
    When The user fills create your account form
      | Field                        | Source          | Data     | isEncrypted | isMasked |
      | email_input_field            | userCredintails | email    | false       | false    |
      | password_input_field         | userCredintails | password | true        | true     |
      | confirm_password_input_field | userCredintails | password | true        | true     |
		When The user check agreement_input
		Then The user should should see all verify icons switched to green