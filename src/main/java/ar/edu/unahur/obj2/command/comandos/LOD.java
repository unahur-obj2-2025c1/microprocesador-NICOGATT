package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD implements Operable {
	public Integer addr;
	
	public LOD(Integer addr) {
		this.addr = addr;
	}
	@Override
	public void execute(Programable micro) {
		Integer valor = micro.getAddr(addr);
		micro.setAcumuladorA(valor);
	}

	@Override
	public void undo(Programable micro) {
		// TODO Auto-generated method stub
		
	}

}
