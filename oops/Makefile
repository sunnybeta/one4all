CC = java
SRC = $(wildcard */*.java)
OBJ = $(SRC:.java=.jar)

all: $(OBJ)

%.jar: %.java
	$(CC) $<

clean:
	rm -rf $(OBJ)
