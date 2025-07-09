all: link

link: main.c link.c link.h
	gcc -o link main.c link.c

run: link
	./link

clean:
	rm -f link