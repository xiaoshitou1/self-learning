package com.study.java8;

import java.util.Optional;

public class OptionalUsage {

    public static void main(String[] args) {
        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
//        insuranceOptional.get();

        Optional<Insurance> insuranceOptiona2 = Optional.of(new Insurance());
//        insuranceOptiona2.get();
//
//        Optional<Insurance> insuranceOptiona3 = Optional.ofNullable(null);
//
//
//
//        insuranceOptiona3.orElseGet(Insurance::new);
//        insuranceOptiona3.orElse(new Insurance());
//        insuranceOptiona3.orElseThrow(RuntimeException::new);
//        insuranceOptiona3.orElseThrow(()->new RuntimeException("not have reference"));

//        Insurance insurance = insuranceOptiona2.filter(i -> i.getName() == null).get();
//        System.out.println(insurance);

//        Optional<String> nameOptional = insuranceOptiona2.map(i -> i.getName());
//        System.out.println(nameOptional.orElse("empty value"));
//        System.out.println(nameOptional.isPresent());
//        nameOptional.ifPresent(System.out::println);

        System.out.println(getInsuranceName(null));
        System.out.println(getInsuranceNameByOptional(null));
    }

    private static String getInsuranceName(Insurance insurance) {
        if (null == insurance) {
            return "unknown";
        }
        return insurance.getName();
    }

    private static String getInsuranceNameByOptional(Insurance insurance) {
        return Optional.ofNullable(insurance).map(i -> i.getName()).orElse("unknown");
    }
}
