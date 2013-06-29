// $Id: FigClassAssociationClass.java 17045 2009-04-05 16:52:52Z mvw $
// Copyright (c) 1996-2009 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.uml.diagram.ui;

import java.awt.Rectangle;

import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.tigris.gef.presentation.Fig;

/**
 * Class to display the Class box fig piece of an Association Class.
 * <em>NOTE:</em> It must be used only from a FigAssociationClass
 *
 * @author pepargouml
 */
public class FigClassAssociationClass extends FigClass {

    private static final long serialVersionUID = -4101337246957593739L;
    
    /**
     * Construct the Class box piece of a complex association class fig.
     * 
     * @param owner owning model element
     * @param bounds position and size
     * @param settings rendering settings
     */
    public FigClassAssociationClass(Object owner, Rectangle bounds, 
            DiagramSettings settings) {
        super(owner, bounds, settings);
        enableSizeChecking(true);
    }
    
    protected Fig getRemoveDelegate() {
        // Look for the dashed edge
        for (Object fig : getFigEdges()) {
            if (fig instanceof FigEdgeAssociationClass) {
                // We have the dashed edge now find the opposite FigNode
                FigEdgeAssociationClass dashedEdge =
                    (FigEdgeAssociationClass) fig;
                return dashedEdge.getRemoveDelegate();
            }
        }
        return null;
    }

}
