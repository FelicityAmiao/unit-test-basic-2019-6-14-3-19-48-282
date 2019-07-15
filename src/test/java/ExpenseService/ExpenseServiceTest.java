package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import org.junit.jupiter.api.Test;

import static ExpenseService.Project.ProjectType.EXTERNAL;
import static ExpenseService.Project.ProjectType.INTERNAL;
import static ExpenseService.Project.ProjectType.UNEXPECTED_PROJECT_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        ExpenseService expenseService = new ExpenseService();
        Project project = new Project(EXTERNAL, "Project B");
        // when
        ExpenseType externalTyteB = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertEquals(ExpenseType.EXPENSE_TYPE_B, externalTyteB);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        ExpenseService expenseService = new ExpenseService();
        Project project = new Project(EXTERNAL, "other name");
        // when
        ExpenseType otherExpense = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertEquals(ExpenseType.OTHER_EXPENSE, otherExpense);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid(){
        // given
        ExpenseService expenseService = new ExpenseService();
        Project project = new Project(UNEXPECTED_PROJECT_TYPE, "unexpect project");
        // when
        UnexpectedProjectTypeException exception = assertThrows(UnexpectedProjectTypeException.class, () -> expenseService.getExpenseCodeByProjectTypeAndName(project));
        // then
        assertTrue(exception.getMessage().equals("You enter invalid project type"));
    }
}