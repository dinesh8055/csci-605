
public class  Overview	{
  int 			instanceVariable;
  static    int 	classVariable;
  final     int 	finalVariable; // static?
  volatile  int 	volatileVariable;
  transient int		transientVariable;


  public Overview()	{
	finalVariable = 42;
	System.out.println(finalVariable + " in Overview()");
  }
  void instanceMethod()	{
	//finalVariable = 43;
	instanceVariable = 22;
	classVariable = 33;
  }

  public static void main(String args[] )	{
	Overview aOverview = new Overview();
	//aOverview.instanceMethod();

  }
}
