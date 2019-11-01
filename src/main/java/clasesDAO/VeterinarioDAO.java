package clasesDAO;

import java.util.List;

import model.Mascota;
import model.Veterinario;

public interface VeterinarioDAO extends Dao<Veterinario> {
	public List<Mascota> getMascotas(Veterinario vet);
}
