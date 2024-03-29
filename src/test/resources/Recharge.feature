Feature: Test Ecom

  @Test123
  Scenario Outline: Verify if recharge is success or not
    Given Launch Url as "<Url>"
    When user selects "<Operator>" , "<CellularNumber>" and "<rechargeAmount>" and click RechargeButton
    Then verify user lands on Payment Screen
    And complete the payment with "<paymentMode>" "<cardNumber>" "<month>" "<date>" "<cvv>" and "<email>"
    Then verify if the recharge is success

    Examples:
      | Url    | Operator     | CellularNumber | rechargeAmount | paymentMode       | cardNumber      | month | date | cvv | email |
      | appUrl | OperatorName | CellNumber     | AmountRecharge | paymentModeMethod | cardNumberPayee | month | date | cvv | email |


  @ValidateSum
  Scenario Outline: Verify the value of sum to be correct
    Given Launch Url as "<Url>"
    When enter value for <firstInput>
    And enter value for "<secondInput>"
    Then Calculate the sum of numbers
    Then validate the "<finalValue>" to be correct



    Examples:
      | Url     | firstInput | firstInput | finalValue |
      | testUrl | 0          | 1          | 1          |