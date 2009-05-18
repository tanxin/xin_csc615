/**
 * Assignment 2
 *
 * Copyright 2005-2009 Shin Tan <tanxincn@gmail.com>
 *
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * 
 * @author  tanxin
 * Editor:  vim
 * Compile: sun-jdk-1.6.0.13 64bit
 * Date:    May 8th 2009
 * Makefile:build.xml (runa2)
 */

package edu.nu.csc615.assignment2;

import java.awt.EventQueue;

public class Assign2 {

	/* entrance point */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Calculator().setVisible(true);
			}
		});
	}

}
