package com.cyl.spring.basicknowledge.methodInjection;

public abstract class HelloImpl implements HelloApi {
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public abstract Printer creatPrototypePrinter();

    public Printer creatSingletonPrinter() {
        System.out.println(" 该方法不会被执行,如果输出就出错了");
        return new Printer();
    }

    private Printer printer;

    @Override
    public void sayHello() {
        printer.print("setter");
        creatPrototypePrinter().print("prototype");
        creatSingletonPrinter().print("singleton");
    }
}
