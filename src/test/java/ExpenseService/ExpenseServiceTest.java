package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import org.junit.jupiter.api.Test;

import static ExpenseService.ExpenseService.getExpenseCodeByProjectTypeAndName;
import static ExpenseService.Project.ProjectType.EXTERNAL;
import static ExpenseService.Project.ProjectType.INTERNAL;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        ExpenseService expenseService = new ExpenseService();
        Project project = new Project(INTERNAL, "");
        // when
        ExpenseType interExpense = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertEquals(ExpenseType.INTERNAL_PROJECT_EXPENSE, interExpense);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        ExpenseService expenseService = new ExpenseService();
        Project project = new Project(EXTERNAL, "Project A");
        // when
        ExpenseType externalTyteA = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertEquals(ExpenseType.EXPENSE_TYPE_A, externalTyteA);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        // when
        // then
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        // when
        // then
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        // when
        // then
    }
}