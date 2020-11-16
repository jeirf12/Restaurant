package co.unicauca.microkernel.common.entities;

/**
 *
 * @author jafes
 */
public class MenuEspecial {
    private int id;
    private int res_id;

    public MenuEspecial(int id, int res_id) {
        this.id = id;
        this.res_id = res_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
    
   
}
