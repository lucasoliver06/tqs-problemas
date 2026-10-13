package out.production;

public class Imatge {
	private int nFiles, nColumnes;
	private float valors[];
	public Imatge() {
		this.nFiles = 0;
		this.nColumnes = 0;
		this.valors = null;
	}
	
	public void CreaImatge(int nfiles, int ncolumnes) {
		assert nfiles > 0 && ncolumnes > 0 : "Les mides han de ser positives";
		
		this.nFiles = nfiles;
		this.nColumnes = ncolumnes;
		this.valors = new float[nfiles * ncolumnes];
	}
	public int getNFiles() {
		return this.nFiles;
	}
	public int getNCols() {
		return this.nColumnes;
	}
	public float getValue(int fila, int col) {
		assert (fila >= 0 && fila < this.getNFiles()) : "La fila esta fora dels limits";
		assert (col >= 0 && col < this.getNCols()) : "La columna esta fora dels limits";
		
		return valors[fila * this.getNCols() + col];		
	}
	public void setValue(int fila, int col, float value) {
	assert (fila >= 0 && fila < this.getNFiles()) : "La fila esta fora dels limits";
	assert (col >= 0 && col < this.getNCols()) : "La columna esta fora dels limits";
	
	
	this.valors[fila * this.getNCols() + col] = value;
	}
}
	
