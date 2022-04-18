export interface Album {
    id: number;
    name: string;
    releaseDate: Date;
    recordLabel: string;
    imageUrl: string;
    artistId: number;
}

export interface AlbumForm {
    name: string;
    releaseDate: Date;
    recordLabel: string;
    imageUrl: string;
    artistId: number;
}