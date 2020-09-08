package br.edu.fafic.enums;

public enum Status {

	TITULAR(1,"Titular"),
	RESERVA(2, "Reserva");
	
	private Integer codigo;
	private String valor;
	
	private Status(Integer codigo, String valor) {
		this.codigo = codigo;
		this.valor = valor;
	}
	
	public static Enum toEnum(Integer codigo) {
		for(Status s : Status.values()) {
			if(codigo.equals(s.codigo)) {
				return s;
			}
		}
		return null;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
