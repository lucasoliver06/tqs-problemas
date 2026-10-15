public class SecondsCalculator {
	public long SegonsFins(int dia, int mes, int any, int hora, int minuts, int segons) {
		assert segons >= 0 && segons <= 59 : "Segons invàlids";
		assert minuts >= 0 && minuts <= 59 : "Minuts invàlids";
		assert hora >= 0 && hora <= 23 : "Hora invàlida";
		assert any >= 1980 : "L'any ha de ser >= 1980";
		assert mes >= 1 && mes <= 12 : "Mes invàlid";
		assert dia >= 1 && dia <= DiesDelMes(mes, any) : "Dia invàlid per aquest mes i any";

		long seg = 0;
		int dies = 0;


		for(int a = 1980; a < any; a++) {
			for(int m = 1; m <= 12; m++) {
				dies += DiesDelMes(m, a);
			}
		}


		for(int x = 1; x < mes; x++) {
			dies += DiesDelMes(x, any);
		}


		for(int d = 1; d < dia; d++) {
			dies += 1;
		}

		seg = hora * 3600L + minuts * 60L + segons + dies * 86400L;

		assert seg >= 0 : "Error intern: s'han calculat segons negatius";

		return seg;

	}
	
	
	private boolean IsAnyTraspas(int any) {
		assert any >= 1980 : "Any invàlid";

		if(any % 400 == 0) return true;
		else if(any % 100 == 0) return false;
		else if(any % 4 == 0) return true;
		else return false;
	}
	
	private int DiesDelMes(int mes, int any) {
		assert any >= 1980 : "Any invàlid";
		assert mes >= 1 && mes <= 12 : "Mes invàlid";

		int diesResultat;

		switch(mes) {
			case 1,3,5,7,8,10,12:
				diesResultat = 31;
				break;
			case 4,6,9,11:
				diesResultat = 30;
				break;
			case 2:
				if (IsAnyTraspas(any)) diesResultat = 29;
				else diesResultat = 28;
				break;
			default:
				diesResultat = -1;
		}
		assert (diesResultat == 28 || diesResultat == 29 || diesResultat == 30 || diesResultat == 31) : "Error en el càlcul de dies";

		return diesResultat;
	}
		
	public int getDiesDelMes(int mes, int any) {
		return DiesDelMes(mes, any);
	}
	
	public boolean getIsAnyTraspas(int any) {
		return IsAnyTraspas(any);
	}
}

