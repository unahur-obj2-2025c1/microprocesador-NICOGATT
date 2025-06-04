package ar.edu.unahur.obj2.command;


import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {
	private Integer A; 
	private Integer B;
	private Integer programCounter = 0;
	private Integer[] memoriaDatos = new Integer[1024];
	
	public Microprocesador(Integer valueA, Integer valueB) {
		this.A = valueA; 
		this.B = valueB;
	}
	
	
	@Override
	public void run(List<Operable> operaciones) {
		operaciones.forEach(instruccion -> {
			instruccion.execute(this);
			incProgramCounter();
		});
	}
	@Override
	public void incProgramCounter() {
		programCounter++;
	}
	@Override
	public Integer getProgramCounter() {
		// TODO Auto-generated method stub
		return programCounter;
	}
	@Override
	public void setAcumuladorA(Integer value) {
		this.A = value;
	}
	@Override
	public Integer getAcumuladorA() {
		// TODO Auto-generated method stub
		return A;
	}
	@Override
	public void setAcumuladorB(Integer value) {
		this.B = value;
	}
	@Override
	public Integer getAcumuladorB() {
		// TODO Auto-generated method stub
		return B;
	}
	@Override
	public void copyFrom(Programable programable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Programable copy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.A = 0; 
		this.B = 0;
	}
	@Override
	public void setAddr(Integer addr) {
		if(addr >= 0 && addr < 1024) {
			memoriaDatos[addr] = this.getAcumuladorA();
		} else {
			throw new MicroException("Direccion fuera de rango: " + addr);
		}
	}
	@Override
	public Integer getAddr(Integer addr) {
		if(addr >= 0 && addr < 1024) {
			return memoriaDatos[addr];
		} else {
			throw new MicroException("Direccion fuera de rango: " + addr);
		}
	}
	
}