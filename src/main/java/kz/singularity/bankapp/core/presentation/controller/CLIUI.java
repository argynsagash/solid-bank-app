package kz.singularity.bankapp.core.presentation.controller;

import kz.singularity.bankapp.features.accounts.presentation.controller.CreateAccountOperationCLIUI;
import kz.singularity.bankapp.features.transactions.presentation.controller.WithdrawDepositOperationCLIUI;

public interface CLIUI extends CreateAccountOperationCLIUI, WithdrawDepositOperationCLIUI {
}
