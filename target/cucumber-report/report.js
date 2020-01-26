$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Recharge.feature");
formatter.feature({
  "name": "Test Ecom",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify if recharge is success or not",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Test123"
    }
  ]
});
formatter.step({
  "name": "Launch Url as \"\u003cUrl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user selects \"\u003cOperator\u003e\" , \"\u003cCellularNumber\u003e\" and \"\u003crechargeAmount\u003e\" and click RechargeButton",
  "keyword": "When "
});
formatter.step({
  "name": "verify user lands on Payment Screen",
  "keyword": "Then "
});
formatter.step({
  "name": "complete the payment with \"\u003cpaymentMode\u003e\" \"\u003ccardNumber\u003e\" \"\u003cmonth\u003e\" \"\u003cdate\u003e\" \"\u003ccvv\u003e\" and \"\u003cemail\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "verify if the recharge is success",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Url",
        "Operator",
        "CellularNumber",
        "rechargeAmount",
        "paymentMode",
        "cardNumber",
        "month",
        "date",
        "cvv",
        "email"
      ]
    },
    {
      "cells": [
        "appUrl",
        "OperatorName",
        "CellNumber",
        "AmountRecharge",
        "paymentModeMethod",
        "cardNumberPayee",
        "month",
        "date",
        "cvv",
        "email"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify if recharge is success or not",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Test123"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch Url as \"appUrl\"",
  "keyword": "Given "
});
formatter.match({
  "location": "RecargasCelularStepDef.launch_Url_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects \"OperatorName\" , \"CellNumber\" and \"AmountRecharge\" and click RechargeButton",
  "keyword": "When "
});
formatter.match({
  "location": "RecargasCelularStepDef.user_selects_and_and_click_RechargeButton(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify user lands on Payment Screen",
  "keyword": "Then "
});
formatter.match({
  "location": "PaymentPageStepDef.verify_user_lands_on_Payment_Screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "complete the payment with \"paymentModeMethod\" \"cardNumberPayee\" \"month\" \"date\" \"cvv\" and \"email\"",
  "keyword": "And "
});
formatter.match({
  "location": "PaymentPageStepDef.complete_the_payment_with_and(String,String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify if the recharge is success",
  "keyword": "Then "
});
formatter.match({
  "location": "PaymentPageStepDef.verify_if_the_recharge_is_success()"
});
formatter.result({
  "status": "passed"
});
formatter.write("SCENARIO_NAME \u003d Verify if recharge is success or not Date \u0026 Time \u003d 2020-01-26 06:17:03");
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});