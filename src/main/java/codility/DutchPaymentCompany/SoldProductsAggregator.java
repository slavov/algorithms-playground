package codility.DutchPaymentCompany;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Build aggregator for a report, which will hold sold products and a sum of their prices converted
 * to EUR currency. To convert price to EUR use EURExchangeService.
 */
public class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        if (products == null) {
            return new SoldProductsAggregate(Collections.emptyList(), BigDecimal.ZERO);
        }
        List<SimpleSoldProduct> simpleSoldProducts =
                products.filter(this::hasExchangeRate)
                        .map(this::toSimpleProduct)
                        .collect(Collectors.toList());

        Optional<BigDecimal> sum =
                simpleSoldProducts.stream()
                        .map(SimpleSoldProduct::getPrice)
                        .reduce(BigDecimal::add);

        return new SoldProductsAggregate(simpleSoldProducts, sum.orElse(BigDecimal.ZERO));
    }

    private SimpleSoldProduct toSimpleProduct(SoldProduct sp) {
        BigDecimal exchangeRate = getExchangeRate(sp);
        return new SimpleSoldProduct(sp.name, sp.getPrice().multiply(exchangeRate));
    }

    private boolean hasExchangeRate(SoldProduct sp) {
        return exchangeService
                        .rate(sp.getCurrency())
                        .orElse(BigDecimal.valueOf(-1))
                        .compareTo(BigDecimal.ZERO)
                > 0;
    }

    private BigDecimal getExchangeRate(SoldProduct sp) {
        return exchangeService.rate(sp.getCurrency()).get();
    }
}

class EURExchangeService {
    Optional<BigDecimal> rate(String currency) {
        return Optional.empty();
    }
}

class SoldProduct {
    String name;
    BigDecimal price;
    String currency;

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}

class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;

    public SoldProductsAggregate(List<SimpleSoldProduct> simpleSoldProducts, BigDecimal sum) {
        this.products = simpleSoldProducts;
        this.total = sum;
    }
}

class SimpleSoldProduct {
    String name;
    BigDecimal price;

    public SimpleSoldProduct(String name, BigDecimal multiply) {
        this.name = name;
        this.price = multiply;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
