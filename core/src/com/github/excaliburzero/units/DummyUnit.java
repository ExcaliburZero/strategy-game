package com.github.excaliburzero.units;

import com.github.excaliburzero.weapons.BasicSword;

/**
 * The <code>Dummy Unit</code> class is a unit class created for testing
 * purposes.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class DummyUnit extends Unit {

    public DummyUnit() {
        super(0, "Dummy", 20, 20, 10, 10, 10, 10, 10, 1, 6, new BasicSword());
    }
}
