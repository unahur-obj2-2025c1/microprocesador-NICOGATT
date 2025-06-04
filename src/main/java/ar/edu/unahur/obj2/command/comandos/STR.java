package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR implements Operable{
	private Integer addr;
	
	public STR(Integer addr) {
		this.addr = addr;
	}
	@Override
	public void execute(Programable micro) {
		micro.setAddr(addr);
	}

	@Override
	public void undo(Programable micro) {
		// TODO Auto-generated method stub
		
	}

}
