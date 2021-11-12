The source code is all included in the jar file. I have also added a copy of the jar file in a zipped format just in case. 
When attempting to run this jar file, I incountered an error where my java version could not open it. The error message was:

Error: LinkageError occurred while loading main class CitationFrame
        java.lang.UnsupportedClassVersionError: CitationFrame has been compiled by a more recent version of the Java Runtime 
	(class file version 59.0), this version of the Java Runtime only recognizes class file versions up to 55.0

I think the problem is that I used java SDK 15. You may need to update your java runtime environment or open the code
in an ide manually.

Jeremy Trendoff - 101160306

