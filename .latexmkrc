#!/usr/bin/env perl

$latex = 'platex %O %S';
$bibtex = 'pbibtex %O %S';
$biber = 'biber --bblencoding=utf8 -u -U --output_safechars %O %S';
$makeindex = 'mendex %O -o %D %S -s dot.ist';
$dvipdf = 'dvipdfmx %O -o %D %S';
add_cus_dep('idx', 'ind', 0, 'makeindex');

sub makeindex {
    system("makeindex $_[0]");
}