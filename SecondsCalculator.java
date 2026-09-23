public class SecondsCalculator {
	public long SegonsFins(int dia, int mes, int any, int hora, int minuts, int segons) {
		
		if(segons < 0 || segons > 59)
			return -1;
		else if(minuts < 0 || minuts > 59)
			return -1;
		else if(hora < 0 || hora > 23)
			return -1;
		else if(any < 1980)
			return -1;
		else if(mes < 1 || mes > 12)
			return -1;
		else if(dia < 1)
			return -1;
		else if(dia > DiesDelMes(mes, any))
			return -1;
		
		
		
		
		
		long seg = 0;
		int dies = 0;


			for(int a = 1980; a < any; a++) {
				for(int m = 1; m <= 12; m++) {
					dies += DiesDelMes(m, a);
				}	
			}


		for(int x = 1; x < mes; x++)
			dies += DiesDelMes(x, any);


		for(int d = 1; d < dia; d++)
			dies += 1;


		seg = hora * 3600 + minuts * 60 + segons + dies * 86400;
		
		return seg;

	}
	
	
	private boolean IsAnyTraspas(int any) {
		if(any % 400 == 0)
			return true;
		else if(any % 100 == 0)
			return false;
		else if(any % 4 == 0)
			return true;
		else
			return false;
	}
	
	private int DiesDelMes(int mes, int any) {
		if(any < 1980)
			return -1;
		
		switch(mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
			
		case 2:
			if (IsAnyTraspas(any))
				return 29;
			else
				return 28;
			
		default:
			return -1;
		}
	}
		
	public int getDiesDelMes(int mes, int any) {
		return DiesDelMes(mes, any);
	}
	
	public boolean getIsAnyTraspas(int any) {
		return IsAnyTraspas(any);
	}
}

