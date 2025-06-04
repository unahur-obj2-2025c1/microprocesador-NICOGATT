package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV implements Operable{
	private Integer val; 
	
	public LODV(Integer val) {
		this.val = val; 
	}
	@Override
	public void execute(Programable micro) {
		micro.setAcumuladorA(val);
	}

	@Override
	public void undo(Programable micro) {
		// TODO Auto-generated method stub
		
	}

}
