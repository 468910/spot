package ica.han.Domain.GraphQL;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

public class Query implements GraphQLResolver {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}
