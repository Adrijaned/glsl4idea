/*
 *     Copyright 2010 Jean-Paul Balabanian and Yngve Devik Hammersland
 *
 *     This file is part of glsl4idea.
 *
 *     Glsl4idea is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as
 *     published by the Free Software Foundation, either version 3 of
 *     the License, or (at your option) any later version.
 *
 *     Glsl4idea is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with glsl4idea.  If not, see <http://www.gnu.org/licenses/>.
 */

package glslplugin.lang.elements;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import glslplugin.GLSLSupportLoader;
import glslplugin.lang.GLSLLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GLSLElementType extends IElementType {
    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(GLSLLanguage.class));

    public GLSLElementType(@NotNull @NonNls String s) {
        super(s, GLSLSupportLoader.GLSL.getLanguage());
    }

    public GLSLElementType(@NotNull @NonNls String debugName, boolean register) {
        super(debugName, GLSLSupportLoader.GLSL.getLanguage(), register);
    }

    //Preprocessor dropins
    public static final class RedefinedTokenElementType extends GLSLElementType {

        public final String text;

        public RedefinedTokenElementType(String text) {
            super("REDEFINED_TOKEN", false);
            this.text = text;
        }
    }
}
