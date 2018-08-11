Fork of https://github.com/casaro/AutoExtend.git to work with FinnWordNet and
ConceptNet.

If you just want the vectors, download them from Releases.

First you need to filter ConceptNet Numberbatch to get only unprefixed Finnish
entries.

    $ python filter_numberbatch.py fi /path/to/numberbatch.txt /path/to/numberbatch_fi.txt

Most of http://www.cis.lmu.de/~sascha/AutoExtend/ applies. More specific
instructions follow:

    $ sed s:FIWN_PATH:/path/to/you/finnwordnet/data/dict/: < WordNetExtractor/jwnl-properties.xml.tmpl > WordNetExtractor/jwnl-properties.xml
    $ cd WordNetExtractor
    $ gradle run --args='jwnl-properties.xml /path/to/numberbatch_fi.txt /path/to/output.dir'
