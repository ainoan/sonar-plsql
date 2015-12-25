/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015-2016 Felipe Zorzo
 * mailto:felipebzorzo AT gmail DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plsqlopen.checks;

import java.util.Collection;

import org.junit.Test;
import org.sonar.plsqlopen.AnalyzerMessage;

public class NvlWithNullParameterCheckTest extends BaseCheckTest {

    @Test
    public void test() {
        Collection<AnalyzerMessage> messages = scanFile("nvl_with_null_parameter.sql", new NvlWithNullParameterCheck());
        final String messageWithNull = "Remove the NULL parameter of this NVL.";
        final String messageWithEmptyString = "Remove the '' parameter of this NVL.";
        AnalyzerMessagesVerifier.verify(messages)
            .next().startsAt(2, 10).endsAt(2, 22).withMessage(messageWithNull)
            .next().startsAt(3, 10).endsAt(3, 22).withMessage(messageWithNull)
            .next().startsAt(4, 10).endsAt(4, 20).withMessage(messageWithEmptyString)
            .next().startsAt(5, 10).endsAt(5, 20).withMessage(messageWithEmptyString)
            .noMore();
    }
    
}
