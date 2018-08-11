import click


def filter_lines(input, prefix):
    for line in input:
        if line.startswith(prefix):
            yield line


@click.command('filter-conceptnet')
@click.argument("lang")
@click.argument("input", type=click.File("r"))
@click.argument("output", type=click.File("w"))
def main(lang, input, output):
    url_prefix = '/c/{}/'.format(lang)
    _, dims = input.readline().split()
    num_elems = sum(1 for _ in filter_lines(input, url_prefix))
    input.seek(0)
    output.write("{} {}\n".format(num_elems, dims))
    for line in filter_lines(input, url_prefix):
        output.write(line[len(url_prefix):])


if __name__ == '__main__':
    main()
