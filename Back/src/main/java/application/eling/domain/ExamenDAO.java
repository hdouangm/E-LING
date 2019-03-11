package application.eling.domain;


public class ExamenDAO extends GenericDAO<Examen>{

	public ExamenDAO() {
		super(Persistence.ELING);
		try {
			Examen ex2 = new Examen();
			ex2.getCodesActes().add(new Acte());
			Examen ex = new Examen();
			ex.getCodesActes().add(new Acte());
			Examen ex3 = new Examen();
			ex3.getCodesActes().add(new Acte());
			this.create(ex2);
			this.create(ex3);
			this.create(ex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
