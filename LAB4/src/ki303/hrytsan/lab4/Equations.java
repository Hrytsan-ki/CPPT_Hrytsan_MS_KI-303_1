package ki303.hrytsan.lab4;

public class Equations {
	
	public double calculate (double x) throws CalcException{
		double y;
		try {
			 y = Math.tan(x)/Math.sin(2*x);
			 if(y==Double.NEGATIVE_INFINITY || y==Double.POSITIVE_INFINITY  || Double.isNaN(y) || (x%(Math.PI/2))<1e-7
					 ||Math.sin(2*x)<1e-7 || Math.cos(x)<1e-7) {
				 throw new ArithmeticException(); 
			 }
		}
		catch(ArithmeticException ex){
			if(Math.sin(2*x)<1e-6) {
				throw new CalcException ("Error: Division by zero occurs");
			}else if(Math.cos(x)<1e-5) {
				throw new CalcException("Error: Tangent does not exist");
			}else {
				throw new CalcException("Error: Unknown reason of the exception during exception calculation");
			}
		}
		return y;
	}
}
