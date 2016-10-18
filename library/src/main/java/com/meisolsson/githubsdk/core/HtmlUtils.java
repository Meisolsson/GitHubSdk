/*
 * Copyright 2015 Henrik Olsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meisolsson.githubsdk.core;

/**
 * HTML Utilities
 */
public class HtmlUtils {

    private static final String TAG_ROOT = "githubroot";

    private static final String ROOT_START = '<' + TAG_ROOT + '>';

    private static final String ROOT_END = "</" + TAG_ROOT + '>';

    private static final String TOGGLE_START = "<span class=\"email-hidden-toggle\">";

    private static final String TOGGLE_END = "</span>";

    private static final String REPLY_START = "<div class=\"email-quoted-reply\">";

    private static final String REPLY_END = "</div>";

    private static final String SIGNATURE_START = "<div class=\"email-signature-reply\">";

    private static final String SIGNATURE_END = "</div>";

    private static final String EMAIL_START = "<div class=\"email-fragment\">";

    private static final String EMAIL_END = "</div>";

    private static final String HIDDEN_REPLY_START = "<div class=\"email-hidden-reply\" style=\" display:none\">";

    private static final String HIDDEN_REPLY_END = "</div>";

    private static final String BREAK = "<br>";

    private static final String PARAGRAPH_START = "<p>";

    private static final String PARAGRAPH_END = "</p>";

    private static final String BLOCKQUOTE_START = "<blockquote>";

    private static final String BLOCKQUOTE_END = "</blockquote>";

    private static final String SPACE = "&nbsp;";

    private static final String PRE_START = "<pre>";

    private static final String PRE_END = "</pre>";

    private static final String CODE_START = "<code>";

    private static final String CODE_END = "</code>";

    /**
     * Format given HTML string so it is ready to be presented in a text view
     *
     * @param html
     * @return formatted HTML
     */
    public static final CharSequence format(final String html) {
        if (html == null)
            return "";
        if (html.length() == 0)
            return "";

        StringBuilder formatted = new StringBuilder(html);

        // Remove e-mail toggle link
        strip(formatted, TOGGLE_START, TOGGLE_END);

        // Remove signature
        strip(formatted, SIGNATURE_START, SIGNATURE_END);

        // Replace div with e-mail content with block quote
        replace(formatted, REPLY_START, REPLY_END, BLOCKQUOTE_START,
                BLOCKQUOTE_END);

        // Remove hidden div
        strip(formatted, HIDDEN_REPLY_START, HIDDEN_REPLY_END);

        // Replace paragraphs with breaks
        if (replace(formatted, PARAGRAPH_START, BREAK))
            replace(formatted, PARAGRAPH_END, BREAK);

        formatPres(formatted);

        formatEmailFragments(formatted);

        trim(formatted);

        formatted.insert(0, ROOT_START);
        formatted.append(ROOT_END);

        return formatted;
    }

    private static StringBuilder strip(final StringBuilder input,
                                       final String prefix, final String suffix) {
        int start = input.indexOf(prefix);
        while (start != -1) {
            int end = input.indexOf(suffix, start + prefix.length());
            if (end == -1)
                end = input.length();
            input.delete(start, end + suffix.length());
            start = input.indexOf(prefix, start);
        }
        return input;
    }

    private static boolean replace(final StringBuilder input,
                                   final String from, final String to) {
        int start = input.indexOf(from);
        if (start == -1)
            return false;

        final int fromLength = from.length();
        final int toLength = to.length();
        while (start != -1) {
            input.replace(start, start + fromLength, to);
            start = input.indexOf(from, start + toLength);
        }
        return true;
    }

    private static StringBuilder replace(final StringBuilder input,
                                         final String fromStart, final String fromEnd, final String toStart,
                                         final String toEnd) {
        int start = input.indexOf(fromStart);
        if (start == -1)
            return input;

        final int fromStartLength = fromStart.length();
        final int fromEndLength = fromEnd.length();
        final int toStartLength = toStart.length();
        while (start != -1) {
            input.replace(start, start + fromStartLength, toStart);
            int end = input.indexOf(fromEnd, start + toStartLength);
            if (end != -1)
                input.replace(end, end + fromEndLength, toEnd);

            start = input.indexOf(fromStart);
        }
        return input;
    }

    private static StringBuilder formatPres(final StringBuilder input) {
        int start = input.indexOf(PRE_START);
        final int spaceAdvance = SPACE.length() - 1;
        final int breakAdvance = BREAK.length() - 1;
        while (start != -1) {
            int end = input.indexOf(PRE_END, start + PRE_START.length());
            if (end == -1)
                break;

            // Skip over code element
            if (input.indexOf(CODE_START, start) == start)
                start += CODE_START.length();
            if (input.indexOf(CODE_END, start) == end - CODE_END.length())
                end -= CODE_END.length();

            for (int i = start; i < end; i++) {
                switch (input.charAt(i)) {
                    case ' ':
                        input.deleteCharAt(i);
                        input.insert(i, SPACE);
                        start += spaceAdvance;
                        end += spaceAdvance;
                        break;
                    case '\t':
                        input.deleteCharAt(i);
                        input.insert(i, SPACE);
                        start += spaceAdvance;
                        end += spaceAdvance;
                        for (int j = 0; j < 3; j++) {
                            input.insert(i, SPACE);
                            start += spaceAdvance + 1;
                            end += spaceAdvance + 1;
                        }
                        break;
                    case '\n':
                        input.deleteCharAt(i);
                        // Ignore if last character is a newline
                        if (i + 1 < end) {
                            input.insert(i, BREAK);
                            start += breakAdvance;
                            end += breakAdvance;
                        }
                        break;
                }
            }
            start = input.indexOf(PRE_START, end + PRE_END.length());
        }
        return input;
    }

    /**
     * Remove email fragment 'div' tag and replace newlines with 'br' tags
     *
     * @param input
     * @return input
     */
    private static StringBuilder formatEmailFragments(final StringBuilder input) {
        int emailStart = input.indexOf(EMAIL_START);
        int breakAdvance = BREAK.length() - 1;
        while (emailStart != -1) {
            int startLength = EMAIL_START.length();
            int emailEnd = input.indexOf(EMAIL_END, emailStart + startLength);
            if (emailEnd == -1)
                break;

            input.delete(emailEnd, emailEnd + EMAIL_END.length());
            input.delete(emailStart, emailStart + startLength);

            int fullEmail = emailEnd - startLength;
            for (int i = emailStart; i < fullEmail; i++)
                if (input.charAt(i) == '\n') {
                    input.deleteCharAt(i);
                    input.insert(i, BREAK);
                    i += breakAdvance;
                    fullEmail += breakAdvance;
                }

            emailStart = input.indexOf(EMAIL_START, fullEmail);
        }
        return input;
    }

    /**
     * Remove leading and trailing whitespace
     *
     * @param input
     */
    private static StringBuilder trim(final StringBuilder input) {
        int length = input.length();
        int breakLength = BREAK.length();

        while (length > 0) {
            if (input.indexOf(BREAK) == 0)
                input.delete(0, breakLength);
            else if (length >= breakLength
                    && input.lastIndexOf(BREAK) == length - breakLength)
                input.delete(length - breakLength, length);
            else if (Character.isWhitespace(input.charAt(0)))
                input.deleteCharAt(0);
            else if (Character.isWhitespace(input.charAt(length - 1)))
                input.deleteCharAt(length - 1);
            else
                break;
            length = input.length();
        }
        return input;
    }
}
