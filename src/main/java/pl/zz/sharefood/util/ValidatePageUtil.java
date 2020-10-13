package pl.zz.sharefood.util;

import pl.zz.sharefood.exception.BadRequestException;

public class ValidatePageUtil {

    public static int validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number cannot beless than zero");
        }
        if (size > AppConstants.MAX_PAGE_SIZE | size < 1) {
            return AppConstants.MAX_PAGE_SIZE;
        }
        return size;
    }
}
