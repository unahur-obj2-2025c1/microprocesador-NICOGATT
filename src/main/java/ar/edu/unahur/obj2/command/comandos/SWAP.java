package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable{

	@Override
	public void execute(Programable micro) {
		micro.setAcumuladorB(micro.getAcumuladorA());
		micro.setAcumuladorA(micro.getAcumuladorB());
	}

	@Override
	public void undo(Programable micro) {
		// TODO Auto-generated method stub
		
	}

}
