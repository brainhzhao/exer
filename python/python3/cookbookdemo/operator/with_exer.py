#!/usr/bin/env python3


#author zhaoheng
#date 20190402
#propose with operator

class WithTest(object):
    
    #init method
    def __enter__(self):
        print("__enter__ call...")
        return self
    def __exit__(self, exc_type, exc_value, traceback):
        print("__exit__ call...")
        print(f"exec_type:{exc_type}")
        print(f"exc_value:{exc_value}")
        print(f"traceback:{traceback}")
        return True

if __name__ == "__main__":
    with WithTest() as test:
        print("heiheihei...")