//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.


package com.openbravo.pos.printer.ticket;

import java.awt.Font;
import java.awt.geom.AffineTransform;

/**
 *
 * @author JG uniCenta
 */
public class BasicTicketForScreen extends BasicTicket {

//    private static Font BASEFONT = new Font("Monospaced", 
    private static Font BASEFONT = new Font("MingLiU",     
            Font.PLAIN, 12).deriveFont(AffineTransform.getScaleInstance(1.0, 1.40));
// JG Feb' 16 - Revert
// Consolas intro'd in v4.1 but causes issue in RightToLeft languages i.e.: Arabic
//    private static Font BASEFONT = new Font("Consolas", Font.PLAIN, 12).deriveFont(AffineTransform.getScaleInstance(1.0, 1.40));    

    private static int FONTHEIGHT = 20;
    private static double IMAGE_SCALE = 1.0;

    /**
     *
     * @return
     */
    @Override
    protected Font getBaseFont() {
        return BASEFONT;
    }

    /**
     *
     * @return
     */
    @Override
    protected int getFontHeight() {
        return FONTHEIGHT;
    }

    /**
     *
     * @return
     */
    @Override
    protected double getImageScale() {
        return IMAGE_SCALE;
    }
}