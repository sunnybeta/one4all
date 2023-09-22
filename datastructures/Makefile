CC = cc
DS = list stack
BIN = bin

all: dirs $(DS)

dirs:
	mkdir -p ./bin

%: %.c
	$(CC) -o $(BIN)/$@ $<

clean:
	rm -r $(BIN) 

