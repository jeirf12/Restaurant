package co.unicauca.microkernel.common.entities;

/**
 *
 * @author fallen
 */
public class MenuDia {
    private int idMenu;
    private DiaEnum diaSem;
    private int resId;

    public MenuDia(int idMenu, DiaEnum diaSem, int resId) {
        this.idMenu = idMenu;
        this.diaSem = diaSem;
        this.resId = resId;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }


    public DiaEnum getDiaSem() {
        return diaSem;
    }

    public void setDiaSem(DiaEnum diaSem) {
        this.diaSem = diaSem;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
    
    
    
}
