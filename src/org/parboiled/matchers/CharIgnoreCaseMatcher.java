/*
 * Copyright (C) 2009 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled.matchers;

import org.parboiled.support.Chars;

public class CharIgnoreCaseMatcher<V> extends CharMatcher<V> {

    public final char characterUp;

    public CharIgnoreCaseMatcher(char character) {
        super(Character.toLowerCase(character));
        this.characterUp = Character.toUpperCase(character);
    }

    @Override
    public AbstractMatcher<V> label(String label) {
        return super.label(label);
    }

    @Override
    public String getLabel() {
        if (hasLabel()) return super.getLabel();

        switch (character) {
            case Chars.EOI:
                return "EOI";
            case Chars.ANY:
                return "ANY";
            case Chars.EMPTY:
                return "EMPTY";
            default:
                return "\'" + character + '/' + characterUp + '\'';
        }
    }

    @Override
    public boolean matches(char current) {
        return super.matches(current) || current == characterUp;
    }

}
