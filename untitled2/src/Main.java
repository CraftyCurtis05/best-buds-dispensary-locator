public class Borrower
{
    public string Name { get; set; }
    public int CreditScore { get; set; }
    public List<string> CreditAlerts { get; set; }
}
class Result
{

    /*
     * Complete the 'CreditCheck' function below.
     *
     * The function is expected to return a BOOLEAN.
     */

    public static boolean CreditCheck(Borrower borrower)
    {   //Check if the borrower's credit score is 750 or above and if the credit alert list is empty
        //Return true if yes
        if (borrower.CreditScore >= 750 && borrower.CreditAlerts.isEmpty() == true) {
            return true;
            //If credit score is under 750 or there are credit alerts, return false
        }else if(borrower.CreditScore < 750 || borrower.CreditAlerts.isEmpty() == false){
            return false;
        }

    }